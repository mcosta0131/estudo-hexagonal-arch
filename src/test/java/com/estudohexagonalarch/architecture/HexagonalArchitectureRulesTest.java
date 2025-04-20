package com.estudohexagonalarch.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class HexagonalArchitectureRulesTest {

    private final JavaClasses importedClasses =
            new ClassFileImporter().importPackages("com.estudohexagonalarch");

    @Test
    @DisplayName("Dominio não deve depender de infrastructure, adapter, controller ou configuration")
    void dominioDeveSerIndependente() {
        ArchRule regra = noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat()
                .resideInAnyPackage(
                        "..infrastructure..",
                        "..adapter..",
                        "..controller..",
                        "..configuration.."
                );

        regra.check(importedClasses);
    }

    @Test
    @DisplayName("Application não deve depender de infrastructure")
    void applicationNaoDeveDependerDeInfrastructure() {
        ArchRule regra = noClasses()
                .that().resideInAPackage("..application..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("..infrastructure..");

        regra.check(importedClasses);
    }

    @Test
    @DisplayName("Somente Adapter Inbound pode conter @RestController")
    void somenteAdapterInboundPodeTerRestControllers() {
        ArchRule regra = classes()
                .that().areAnnotatedWith("org.springframework.web.bind.annotation.RestController")
                .should().resideInAPackage("..adapter.inbound..");

        regra.check(importedClasses);
    }

    @Test
    @DisplayName("Ports (Application) não devem depender do Spring Framework")
    void portsNaoDevemDependerDeSpring() {
        ArchRule regra = noClasses()
                .that().resideInAPackage("..application..")
                .should().dependOnClassesThat()
                .resideInAnyPackage("org.springframework..");

        regra.check(importedClasses);
    }
}
