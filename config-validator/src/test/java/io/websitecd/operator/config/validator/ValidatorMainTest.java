package io.websitecd.operator.config.validator;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class ValidatorMainTest {

    @Inject
    ValidatorMain validatorMain;

    @Test
    void noInput() throws Exception {
        assertEquals(1, validatorMain.checkAndValidate(Optional.empty(), null));
    }

    @BeforeAll
    public static void loadFile() {
        validFile = ValidatorMainTest.class.getResource("/valid-simple-website.yaml").getFile();
        invalidFile = ValidatorMainTest.class.getResource("/invalid-apiVersion.yaml").getFile();
    }

    static String validFile, invalidFile;

    @Test
    void validFilePath() throws Exception {
        assertEquals(0, validatorMain.checkAndValidate(Optional.of(validFile), null));
    }

    @Test
    void validArg() throws Exception {
        assertEquals(0, validatorMain.checkAndValidate(Optional.empty(), validFile));
    }

    @Test
    void validArgMultiple() throws Exception {
        assertEquals(0, validatorMain.checkAndValidate(Optional.empty(), validFile, validFile));
    }

    @Test
    void validBoth() throws Exception {
        assertEquals(0, validatorMain.checkAndValidate(Optional.of(validFile), validFile));
    }

    @Test
    void invalidOneFile() throws Exception {
        assertEquals(1, validatorMain.checkAndValidate(Optional.of(invalidFile), null));
    }
    @Test
    void invalidTwoFiles() throws Exception {
        assertEquals(2, validatorMain.checkAndValidate(Optional.of(invalidFile), invalidFile));
    }

}