package com.neusoft.medical.service.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.neusoft.medical.bean.*;
import com.neusoft.medical.dao.*;
import com.neusoft.medical.service.WorkloadStatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class WorkloadStatisticsServiceImpl implements WorkloadStatisticsService {
    @Resource
    private RegistrationMapper registrationMapper;
    @Resource
    private ChargeFormMapper chargeFormMapper;
    @Resource
    private ChargeEntryMapper chargeEntryMapper;
    @Resource
    private PrescriptionMapper prescriptionMapper;
    @Resource
    private PrescriptionEntryMapper prescriptionEntryMapper;
    @Resource
    private InvoiceMapper invoiceMapper;
    @Resource
    private DoctorMapper doctorMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private PatientMapper patientMapper;

    private String doctorWorkloadStatistics(Date startDatetime, Date endDatetime, Integer doctorId) {
        JsonObject workloadStatistics = new JsonObject();

        // 工作量统计：患者数量与每个患者的药费、检查检验费、处置费
        RegistrationExample registrationExample = new RegistrationExample();
        registrationExample.or().andValidEqualTo(1).andRegistrationDateBetween(startDatetime, endDatetime).andDoctorIdEqualTo(doctorId);
        List<Registration> doctorRegistrationList = registrationMapper.selectByExample(registrationExample);

        Set<Integer> patientIdSet = new CopyOnWriteArraySet<>();
        for (Registration registration : doctorRegistrationList) {
            patientIdSet.add(registration.getPatientId());
        }
        workloadStatistics.addProperty("patientNums", patientIdSet.size());  // 患者数量
        JsonArray patientJsonArray = new JsonArray();
        for (Integer patientId : patientIdSet) {
            JsonObject patientJsonObject = new JsonObject();
            double patientExaminationFee = 0.0;
            double patientDisposalFee = 0.0;
            double patientPrescriptionFee = 0.0;

            // 找到该患者在该医生名下的所有挂号，计算就诊过程中产生检查检验费、处置费、药费
            RegistrationExample patientRegistrationExample = new RegistrationExample();
            patientRegistrationExample.or().andValidEqualTo(1).andPatientIdEqualTo(patientId).andDoctorIdEqualTo(doctorId);
            List<Registration> patientRegistrationList = registrationMapper.selectByExample(patientRegistrationExample);
            List<Integer> patientRegistrationIdList = new CopyOnWriteArrayList<>();

            for (Registration registration : patientRegistrationList) {
                patientRegistrationIdList.add(registration.getRegistrationId());
            }

            List<Integer> chargeFormIdList = null;
            if (!patientRegistrationIdList.isEmpty()) {
                ChargeFormExample chargeFormExample = new ChargeFormExample();
                chargeFormExample.or().andValidEqualTo(1).andRegistrationIdIn(patientRegistrationIdList);
                List<ChargeForm> chargeFormList = chargeFormMapper.selectByExample(chargeFormExample);
                chargeFormIdList = new CopyOnWriteArrayList<>();
                for (ChargeForm chargeForm : chargeFormList) {
                    chargeFormIdList.add(chargeForm.getChargeFormId());
                }
            }

            if (chargeFormIdList != null && !chargeFormIdList.isEmpty()) {
                ChargeEntryExample chargeEntryExample = new ChargeEntryExample();
                chargeEntryExample.or().andValidEqualTo(1).andChargeFormIdIn(chargeFormIdList);
                List<ChargeEntry> chargeEntryList = chargeEntryMapper.selectByExample(chargeEntryExample);
                for (ChargeEntry chargeEntry : chargeEntryList) {
                    if (chargeEntry.getExaminationId() != null) {
                        patientExaminationFee += chargeEntry.getTotalPrice();
                    } else if (chargeEntry.getChargeFormId() != null) {
                        patientDisposalFee += chargeEntry.getTotalPrice();
                    }
                }
            }

            List<Integer> prescriptionIdList = null;
            if (!patientRegistrationIdList.isEmpty()) {
                PrescriptionExample prescriptionExample = new PrescriptionExample();
                prescriptionExample.or().andValidEqualTo(1).andRegistrationIdIn(patientRegistrationIdList);
                List<Prescription> prescriptionList = prescriptionMapper.selectByExample(prescriptionExample);
                prescriptionIdList = new CopyOnWriteArrayList<>();
                for (Prescription prescription : prescriptionList) {
                    prescriptionIdList.add(prescription.getPrescriptionId());
                }
            }

            if (prescriptionIdList != null && !prescriptionIdList.isEmpty()) {
                PrescriptionEntryExample prescriptionEntryExample = new PrescriptionEntryExample();
                prescriptionEntryExample.or().andValidEqualTo(1).andPrescriptionIdIn(prescriptionIdList);
                List<PrescriptionEntry> prescriptionEntryList = prescriptionEntryMapper.selectByExample(prescriptionEntryExample);
                for (PrescriptionEntry prescriptionEntry : prescriptionEntryList) {
                    patientPrescriptionFee += prescriptionEntry.getTotalPrice();
                }
            }

            patientJsonObject.addProperty("patientExaminationFee", patientExaminationFee);
            patientJsonObject.addProperty("patientDisposalFee", patientDisposalFee);
            patientJsonObject.addProperty("patientPrescriptionFee", patientPrescriptionFee);
            patientJsonObject.addProperty("patientName", patientMapper.selectByPrimaryKey(patientId).getPatientName());
            patientJsonArray.add(patientJsonObject);
        }
        workloadStatistics.add("patientChargeInfo", patientJsonArray);  // 患者数量
        return workloadStatistics.toString();
    }

    @Override
    public String outpatientDoctorWorkloadStatistics(Date startDatetime, Date endDatetime, Integer doctorId) {
        return doctorWorkloadStatistics(startDatetime, endDatetime, doctorId);
    }

    @Override
    public String techDoctorWorkloadStatistics(Date startDatetime, Date endDatetime, Integer doctorId) {
        return doctorWorkloadStatistics(startDatetime, endDatetime, doctorId);
    }

    @Override
    public String departmentWorkloadFinancialStatistics(Date startDatetime, Date endDatetime) {
        JsonArray departmentWorkloadJsonArray = new JsonArray();

        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.or().andValidEqualTo(1);
        List<Department> departmentList = departmentMapper.selectByExample(departmentExample);

        for (Department department : departmentList) {
            JsonObject departmentJsonObject = new JsonObject();
            DoctorExample doctorExample = new DoctorExample();
            doctorExample.or().andValidEqualTo(1).andDepartmentIdEqualTo(department.getDepartmentId());

            List<Doctor> doctorList = doctorMapper.selectByExample(doctorExample);
            List<Integer> doctorIdList = new CopyOnWriteArrayList<>();
            for (Doctor doctor : doctorList) {
                doctorIdList.add(doctor.getDoctorId());
            }

            List<Integer> registrationIdList = null;
            if (!doctorIdList.isEmpty()) {
                RegistrationExample registrationExample = new RegistrationExample();
                registrationExample.or().andValidEqualTo(1).andDoctorIdIn(doctorIdList).andRegistrationDateBetween(startDatetime, endDatetime);
                List<Registration> registrationList = registrationMapper.selectByExample(registrationExample);
                registrationIdList = new CopyOnWriteArrayList<>();
                for (Registration registration : registrationList) {
                    registrationIdList.add(registration.getRegistrationId());
                }
            }

            double departmentPrescriptionFee = 0.0;
            double departmentExaminationFee = 0.0;
            double departmentDisposalFee = 0.0;
            int departmentInvoiceNums = 0;
            if (registrationIdList != null && !registrationIdList.isEmpty()) {
                InvoiceExample invoiceExample = new InvoiceExample();
                invoiceExample.or().andValidEqualTo(1).andRegistrationIdIn(registrationIdList).andPayTimeBetween(startDatetime, endDatetime);
                List<Invoice> invoiceList = invoiceMapper.selectByExample(invoiceExample);

                for (Invoice invoice : invoiceList) {
                    departmentPrescriptionFee += invoice.getPrescriptionFee();
                    departmentExaminationFee += invoice.getExaminationFee();
                    departmentDisposalFee += invoice.getDisposalFee();
                    departmentInvoiceNums += invoice.getInvoiceNums();
                }
            }

            departmentJsonObject.addProperty("departmentPrescriptionFee", departmentPrescriptionFee);
            departmentJsonObject.addProperty("departmentExaminationFee", departmentExaminationFee);
            departmentJsonObject.addProperty("departmentDisposalFee", departmentDisposalFee);
            departmentJsonObject.addProperty("departmentInvoiceNums", departmentInvoiceNums);
            departmentJsonObject.addProperty("departmentName", department.getDepartmentName());

            departmentWorkloadJsonArray.add(departmentJsonObject);
        }
        return departmentWorkloadJsonArray.toString();

    }

    @Override
    public String doctorWorkloadFinancialStatistics(Date startDatetime, Date endDatetime) {
        JsonArray doctorWorkloadJsonArray = new JsonArray();

        DoctorExample doctorExample = new DoctorExample();
        doctorExample.or().andValidEqualTo(1);
        List<Doctor> doctorList = doctorMapper.selectByExample(doctorExample);
        Set<Integer> doctorIdSet = new CopyOnWriteArraySet<>();
        for (Doctor doctor : doctorList) {
            doctorIdSet.add(doctor.getDoctorId());
        }

        for (Integer doctorId : doctorIdSet) {
            JsonObject doctorJsonObject = new JsonObject();
            // 获取该医生在指定时间段内的看诊人次、各项收费总额

            RegistrationExample doctorRegistrationExample = new RegistrationExample();
            doctorRegistrationExample.or().andValidEqualTo(1).andDoctorIdEqualTo(doctorId).andRegistrationDateBetween(startDatetime, endDatetime);
            List<Registration> doctorRegistrationList = registrationMapper.selectByExample(doctorRegistrationExample);
            List<Integer> doctorRegistrationIdList = new CopyOnWriteArrayList<>();
            for (Registration registration : doctorRegistrationList) {
                doctorRegistrationIdList.add(registration.getRegistrationId());
            }
            doctorJsonObject.addProperty("visitNums", doctorRegistrationList.size());  // 看诊人次

            double doctorPrescriptionFee = 0.0;
            double doctorExaminationFee = 0.0;
            double doctorDisposalFee = 0.0;
            int doctorInvoiceNums = 0;
            if (!doctorRegistrationIdList.isEmpty()) {
                InvoiceExample invoiceExample = new InvoiceExample();
                invoiceExample.or().andValidEqualTo(1).andRegistrationIdIn(doctorRegistrationIdList).andPayTimeBetween(startDatetime, endDatetime);
                List<Invoice> invoiceList = invoiceMapper.selectByExample(invoiceExample);
                for (Invoice invoice : invoiceList) {
                    doctorPrescriptionFee += invoice.getPrescriptionFee();
                    doctorExaminationFee += invoice.getExaminationFee();
                    doctorDisposalFee += invoice.getDisposalFee();
                    doctorInvoiceNums += invoice.getInvoiceNums();
                }
            }

            doctorJsonObject.addProperty("doctorPrescriptionFee", doctorPrescriptionFee);
            doctorJsonObject.addProperty("doctorExaminationFee", doctorExaminationFee);
            doctorJsonObject.addProperty("doctorDisposalFee", doctorDisposalFee);
            doctorJsonObject.addProperty("doctorInvoiceNums", doctorInvoiceNums);
            doctorJsonObject.addProperty("doctorName", doctorMapper.selectByPrimaryKey(doctorId).getDoctorName());
            doctorWorkloadJsonArray.add(doctorJsonObject);  // 添加到统计医生工作量的数组
        }

        return doctorWorkloadJsonArray.toString();
    }
}
