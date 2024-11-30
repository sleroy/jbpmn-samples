# Création d'un projet JBPMN via Maven

## Créer du projet

Exécutez la commande suivante :

```bash
mvn archetype:generate -DgroupId=com.example.jbpm -DartifactId=jbpm-project -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

```

## Ajouter les dépendances

Insérer les lignes suivantes dans le fichier `pom.xml`:

```xml
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.release>8</maven.compiler.release>
    <version.org.drools>7.74.1.Final</version.org.drools>
    <version.org.jbpm>7.74.1.Final</version.org.jbpm>
    <hibernate.version>4.2.0.Final</hibernate.version>
    <hibernate.core.version>4.2.0.Final</hibernate.core.version>
    <slf4j.version>1.7.30</slf4j.version>
    <jboss.javaee.version>1.0.0.Final</jboss.javaee.version>
    <logback.version>1.0.9</logback.version>
    <h2.version>1.3.161</h2.version>
    <narayana.version>5.9.0.Final</narayana.version>
    <jta.version>1.0.1.Final</jta.version>
    <junit.version>4.13.1</junit.version>
    <xstream.version>1.4.20</xstream.version>
  </properties>

  <dependencyManagement>
    <dependencies>
      <!-- define drools BOM -->
      <dependency>
        <groupId>org.drools</groupId>
        <artifactId>drools-bom</artifactId>
        <type>pom</type>
        <version>${version.org.drools}</version>
        <scope>import</scope>
      </dependency>
      <!-- define drools BOM -->
      <dependency>
        <groupId>org.jbpm</groupId>
        <artifactId>jbpm-bom</artifactId>
        <type>pom</type>
        <version>${version.org.jbpm}</version>
        <scope>import</scope>
      </dependency>
      <dependency>
        <groupId>org.junit</groupId>
        <artifactId>junit-bom</artifactId>
        <version>5.11.0</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>

  <dependencyManagement>
    <dependencies>
      <!-- define drools BOM -->
      <dependency>
        <groupId>org.drools</groupId>
        <artifactId>drools-bom</artifactId>
        <type>pom</type>
        <version>${version.org.drools}</version>
        <scope>import</scope>
      </dependency>
      <!-- define drools BOM -->
      <dependency>
        <groupId>org.jbpm</groupId>
        <artifactId>jbpm-bom</artifactId>
        <type>pom</type>
        <version>${version.org.jbpm}</version>
        <scope>import</scope>
      </dependency>
      <dependency>
        <groupId>org.junit</groupId>
        <artifactId>junit-bom</artifactId>
        <version>5.11.0</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>

  <dependencies>

    <dependency>
      <groupId>org.drools</groupId>
      <artifactId>drools-core</artifactId>
      <version>${version.org.drools}</version>
    </dependency>
    <dependency>
      <groupId>org.drools</groupId>
      <artifactId>drools-compiler</artifactId>
      <version>${version.org.drools}</version>
    </dependency>
    <dependency>
      <groupId>org.jbpm</groupId>
      <artifactId>jbpm-bpmn2</artifactId>
    </dependency>
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.5.12</version>
    </dependency>
    <dependency>
      <groupId>org.jbpm</groupId>
      <artifactId>jbpm-bpmn2</artifactId>
    </dependency>

    <dependency>
      <groupId>org.jbpm</groupId>
      <artifactId>jbpm-test</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-log4j12</artifactId>
      <version>1.7.30</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>${slf4j.version}</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-simple</artifactId>
      <version>${slf4j.version}</version>
    </dependency>

    <dependency>
      <groupId>org.kie</groupId>
      <artifactId>kie-api</artifactId>
      <version>${version.org.jbpm}</version>
    </dependency>
    <dependency>
      <groupId>org.kie</groupId>
      <artifactId>kie-internal</artifactId>
      <version>${version.org.jbpm}</version>
    </dependency>
    <dependency>
      <groupId>org.optaplanner</groupId>
      <artifactId>optaplanner-core</artifactId>
      <version>7.73.0.Final</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>org.optaplanner</groupId>
      <artifactId>optaplanner-persistence-jaxb</artifactId>
      <version>7.73.0.Final</version>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-api</artifactId>
      <scope>test</scope>
    </dependency>
    <!-- Optionally: parameterized tests support -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-params</artifactId>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>com.thoughtworks.xstream</groupId>
      <artifactId>xstream</artifactId>
      <version>${xstream.version}</version>
    </dependency>
  </dependencies>
  <build>
    <sourceDirectory>src</sourceDirectory>
    <plugins>
        <plugin>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>1.4.0</version>
        <configuration>
          <mainClass>com.example.jbpm.App</mainClass>
        </configuration>
      </plugin>

      <plugin>
        <groupId>org.kie</groupId>
        <artifactId>kie-maven-plugin</artifactId>
        <extensions>true</extensions>
      </plugin>
    </plugins>
  </build>
```

## Création du réertoire pour les ressources

- Création du répertoire `src/main/resources/META-INF`
- Créer un fichier `OrderApproval.bpmn` dans le répertoire `src/main/resources`

Exemple de contenu minimal

```xml
<!-- Processus -->
  <bpmn2:process id="PretImmmobilier.OrderApproval" drools:packageName="org.jbpm" drools:version="1.0" drools:adHoc="false" name="OrderApproval" isExecutable="true" processType="Public">
    <bpmn2:sequenceFlow id="_B85D2D81-85B3-4A8A-91FA-6B0B34930005" sourceRef="_43A4F60E-992E-49A2-94CD-22113A5C140E" targetRef="_9036B7AD-7522-4094-B20D-CE4C43C1AC4E">
      <bpmn2:extensionElements>
        <drools:metaData name="isAutoConnection.target">
          <drools:metaValue><![CDATA[true]]></drools:metaValue>
        </drools:metaData>
      </bpmn2:extensionElements>
    </bpmn2:sequenceFlow>
    <bpmn2:sequenceFlow id="_34A18F0A-1BE6-4B3F-867D-6328B736462D" sourceRef="_A5912C49-B64F-4110-AD0D-F4CB7BF9EF21" targetRef="_43A4F60E-992E-49A2-94CD-22113A5C140E">
      <bpmn2:extensionElements>
        <drools:metaData name="isAutoConnection.source">
          <drools:metaValue><![CDATA[true]]></drools:metaValue>
        </drools:metaData>
        <drools:metaData name="isAutoConnection.target">
          <drools:metaValue><![CDATA[true]]></drools:metaValue>
        </drools:metaData>
      </bpmn2:extensionElements>
    </bpmn2:sequenceFlow>
    <bpmn2:endEvent id="_9036B7AD-7522-4094-B20D-CE4C43C1AC4E" name="End">
      <bpmn2:extensionElements>
        <drools:metaData name="elementname">
          <drools:metaValue><![CDATA[End]]></drools:metaValue>
        </drools:metaData>
      </bpmn2:extensionElements>
      <bpmn2:incoming>_B85D2D81-85B3-4A8A-91FA-6B0B34930005</bpmn2:incoming>
    </bpmn2:endEvent>
    <bpmn2:startEvent id="_A5912C49-B64F-4110-AD0D-F4CB7BF9EF21" name="Start">
      <bpmn2:extensionElements>
        <drools:metaData name="elementname">
          <drools:metaValue><![CDATA[Start]]></drools:metaValue>
        </drools:metaData>
      </bpmn2:extensionElements>
      <bpmn2:outgoing>_34A18F0A-1BE6-4B3F-867D-6328B736462D</bpmn2:outgoing>
    </bpmn2:startEvent>
    <bpmn2:userTask id="_43A4F60E-992E-49A2-94CD-22113A5C140E" name="Review Order">
      <bpmn2:extensionElements>
        <drools:metaData name="elementname">
          <drools:metaValue><![CDATA[Review Order]]></drools:metaValue>
        </drools:metaData>
      </bpmn2:extensionElements>
      <bpmn2:incoming>_34A18F0A-1BE6-4B3F-867D-6328B736462D</bpmn2:incoming>
      <bpmn2:outgoing>_B85D2D81-85B3-4A8A-91FA-6B0B34930005</bpmn2:outgoing>
      <bpmn2:ioSpecification id="_NXXv4a8vEe-n2rbuyX885Q">
        <bpmn2:dataInput id="_43A4F60E-992E-49A2-94CD-22113A5C140E_TaskNameInputX" drools:dtype="Object" itemSubjectRef="__43A4F60E-992E-49A2-94CD-22113A5C140E_TaskNameInputXItem" name="TaskName"/>
        <bpmn2:dataInput id="_43A4F60E-992E-49A2-94CD-22113A5C140E_SkippableInputX" drools:dtype="Object" itemSubjectRef="__43A4F60E-992E-49A2-94CD-22113A5C140E_SkippableInputXItem" name="Skippable"/>
        <bpmn2:inputSet id="_NXXv4q8vEe-n2rbuyX885Q">
          <bpmn2:dataInputRefs>_43A4F60E-992E-49A2-94CD-22113A5C140E_TaskNameInputX</bpmn2:dataInputRefs>
          <bpmn2:dataInputRefs>_43A4F60E-992E-49A2-94CD-22113A5C140E_SkippableInputX</bpmn2:dataInputRefs>
        </bpmn2:inputSet>
        <bpmn2:outputSet id="_NXXv468vEe-n2rbuyX885Q"/>
      </bpmn2:ioSpecification>
      <bpmn2:dataInputAssociation id="_NXXv5K8vEe-n2rbuyX885Q">
        <bpmn2:targetRef>_43A4F60E-992E-49A2-94CD-22113A5C140E_TaskNameInputX</bpmn2:targetRef>
        <bpmn2:assignment id="_NXXv5a8vEe-n2rbuyX885Q">
          <bpmn2:from xsi:type="bpmn2:tFormalExpression" id="_NXXv5q8vEe-n2rbuyX885Q"><![CDATA[Task]]></bpmn2:from>
          <bpmn2:to xsi:type="bpmn2:tFormalExpression" id="_NXXv568vEe-n2rbuyX885Q">_43A4F60E-992E-49A2-94CD-22113A5C140E_TaskNameInputX</bpmn2:to>
        </bpmn2:assignment>
      </bpmn2:dataInputAssociation>
      <bpmn2:dataInputAssociation id="_NXXv6K8vEe-n2rbuyX885Q">
        <bpmn2:targetRef>_43A4F60E-992E-49A2-94CD-22113A5C140E_SkippableInputX</bpmn2:targetRef>
        <bpmn2:assignment id="_NXXv6a8vEe-n2rbuyX885Q">
          <bpmn2:from xsi:type="bpmn2:tFormalExpression" id="_NXXv6q8vEe-n2rbuyX885Q"><![CDATA[false]]></bpmn2:from>
          <bpmn2:to xsi:type="bpmn2:tFormalExpression" id="_NXXv668vEe-n2rbuyX885Q">_43A4F60E-992E-49A2-94CD-22113A5C140E_SkippableInputX</bpmn2:to>
        </bpmn2:assignment>
      </bpmn2:dataInputAssociation>
    </bpmn2:userTask>
  </bpmn2:process>

```

## Création du programme pour charger et démarrer le processus

Créer une classe pour démarrer le processus

```java
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.KieServices;

public class Main {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();

        kieSession.startProcess("orderApproval");
        kieSession.dispose();
    }
}
```

## Exécuter le script pour vérifier son fonctionnement

Lancer via votre IDE, la classe APP.

Important, vérifiez que les dépendances :

```xml
    <dependency>
      <groupId>org.jbpm</groupId>
      <artifactId>jbpm-bpmn2</artifactId>
    </dependency>
    <dependency>
      <groupId>org.jbpm</groupId>
      <artifactId>jbpm-flow</artifactId>
    </dependency>
```

Soient bien présentes.
