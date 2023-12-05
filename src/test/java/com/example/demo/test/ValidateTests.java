package com.example.demo.test;

import com.example.demo.model.GroupInfo;
import com.example.demo.model.GroupSubItem;
import com.example.demo.model.ValidateItem;
import com.example.demo.service.IValidItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class ValidateTests extends BaseTest {

    private final String _outputFormat = "property : %s, value : %s, 정합성 오류 : %s";
    @Autowired
    private IValidItemService _service;
    @Test
    public void itemTest() {
        ValidateItem item = new ValidateItem();
        item.setUserId("aa");
        item.setAvg(-1);
//        item.setEmail("aa@ddd");
        item.setEmail("AA");

        Set<ConstraintViolation<ValidateItem>> validResult = runValid(item);

        outputError(validResult);
    }

    @Test
    public void emptyDataTest() {
        ValidateItem item = new ValidateItem();
        outputError(runValid(item));
    }

    @Test
    public void itemAnnoTest() {
        ValidateItem item = new ValidateItem();
        item.setUserId("mhkim222");
        item.setAvg(11);
        item.setEmail("abc@test.com");
        boolean result = _service.checkItem(item);
        WriteDebug(String.valueOf(result));
    }

    @Test
    public void GroupTest() {
        GroupInfo info = new GroupInfo();
        List<GroupSubItem> subItems = info.getSubItems();
        GroupSubItem sub1 = new GroupSubItem();
        sub1.setSubGroupSeq(1);
        sub1.setData("");
        subItems.add(sub1);

        var result = runValid(info);
        outputError(result);
    }

    @Test
    void GroupServiceTest() {
        GroupInfo info = new GroupInfo();
        info.setGroupId(1);
        info.setGroupName("test");
        List<GroupSubItem> subItems = info.getSubItems();
        GroupSubItem sub1 = new GroupSubItem();
        sub1.setSubGroupSeq(1);
        sub1.setData("ㅁ");
        subItems.add(sub1);

        GroupSubItem sub2 = new GroupSubItem();
        sub2.setSubGroupSeq(2);
        sub2.setData("");
        subItems.add(sub2);
        boolean result = _service.checkGroupInfo(info);

    }


    private <T> Set<ConstraintViolation<T>> runValid(T item) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(item);
    }

    private <T> void outputError(Set<ConstraintViolation<T>> outputData) {
        //outputData.forEach(i -> WriteDebug(i.toString()));
        outputData.forEach(i -> WriteDebug(String.format(_outputFormat, i.getPropertyPath().toString(), i.getInvalidValue(), i.getMessage())));
    }


//    private <T> boolean runValidAnnotation(@Valid T item) {
//        return true;
//    }

}
