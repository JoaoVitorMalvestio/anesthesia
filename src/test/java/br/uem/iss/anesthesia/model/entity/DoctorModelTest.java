package br.uem.iss.anesthesia.model.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.mockito.internal.util.StringUtil;

import static org.junit.Assert.*;

public class DoctorModelTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void doctorName() {
        String nome;
        DoctorModel doctorName = new DoctorModel();
        nome = "Mateus Lupi";
        doctorName.setName(nome);
        Assert.assertEquals(nome, doctorName.getName());

    }

    @Test
    public void doctorCrm() {
        String crm = "10135858";
        DoctorModel doctor = new DoctorModel();
        doctor.setCrm(crm);
        Assert.assertEquals(crm,doctor.getCrm());
    }

    @Test
    public void doctorPhoneNumber() {
        String phone = "3034-0190";
        DoctorModel doctor = new DoctorModel();
        doctor.setPhoneNumber(phone);
        Assert.assertEquals(phone,doctor.getPhoneNumber());
    }

    @Test
    public void doctorCellphoneNumber() {
        String phoneNumber = "99210508";
        DoctorModel doctor = new DoctorModel();
        doctor.setCellphoneNumber(phoneNumber);
        Assert.assertEquals(phoneNumber,doctor.getCellphoneNumber());
    }

    @Test
    public void doctorEmail() {
        String email = "mateus_lupi";
        DoctorModel doctor = new DoctorModel();
        doctor.setEmail(email);
        Assert.assertEquals(email,doctor.getEmail());
    }

    @Test
    public void doctorDiaSemanaManha() {
        boolean dia = true ;
        DoctorModel doctor = new DoctorModel();
        doctor.setDomingoManha(dia);
        Assert.assertEquals(dia,doctor.isDomingoManha());
    }

    @Test
    public void doctorDiaSemanaTarde() {
        boolean dia = true ;
        DoctorModel doctor = new DoctorModel();
        doctor.setDomingoTarde(dia);
        Assert.assertEquals(dia,doctor.isDomingoTarde());
    }


}