[![Build Status](https://dev.azure.com/saymonoliveira/Templates%20Pipelines/_apis/build/status/Templates%20Pipelines-Maven-CI?branchName=headless)](https://dev.azure.com/saymonoliveira/Templates%20Pipelines/_build/latest?definitionId=2&branchName=headless)


## Automação

- Arquitetura Projeto
	- Linguagem	- [Java](https://www.java.com/pt-BR// "Java")
	- [Java Kit Development versão 8](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
	- Gestão de dependências - [Maven](https://maven.apache.org)
	- Framework de Testes automatizass web - [Selenium.WebDriver 3.141](https://www.seleniumhq.org/download/ "Selenium.WebDriver") 
	- Orquestrador de testes - [TestNG](https://testng.org/doc/ "TestNG")
	- Relatório de testes automatizados - [ExtentReports 4.0.9](http://www.extentreports.com/docs/versions/4/java/index.html "ExtentReports 4.0.9")

## Setup para executar o projeto

- Versão 1.8 do Java JDK instalada no computador (https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- Versão community do IntelliJ IDEA instalada no computador (https://www.jetbrains.com/pt-br/idea/download/#section=windows)
- Última versão do Google Chrome instalada no computador (https://www.google.com/chrome/) - neste momento Google Chrome 86
- Baixar o projeto, construi-lo e acessar a pasta tests que estará o teste de exemplo.

## Arquitetura

**Premissas de uma boa arquitetura de automação de testes:**
*  Facilitar o desenvolvimento dos testes automatizados (reuso).
*  Facilitar a manutenção dos testes (refatoração).
*  Tornar o fluxo do teste o mais legível possível (fácil entendimento do que está sendo testado).

**Arquitetura padrão Base2**

Para facilitar o entendimento da arquitetura do projeto de testes automatizados, foi criado um fluxograma baseado nas features principais que envolvam a arquitetura conforme imagem abaixo:

![alt text](https://i.imgur.com/wexOWJF.png)


## Configuração do Ambiente

A configuração do ambiente Mantis utilizando Docker foi feita através deste [tutorial](https://github.com/saymowan/Mantis4Testers-Docker/tree/master)

- Selenium Grid

![image](https://github.com/LeonardoMFS/desafioWebBase/assets/90872650/5f86fbbb-7cbf-44cd-8183-3840f8717199)


## Desafio

O desafio tem por objetivo a criação de 50 scripts de automação. Deste total, alguns scripts devem ser DataDriven e também fazer uso de JavaScript.

- Classe de testes
  
![image](https://github.com/LeonardoMFS/desafioWebBase/assets/90872650/5e8d3a16-d7f2-4db2-8bd9-3d815c0966a1)

- Exemplo de cenário DataDriven
  
![image](https://github.com/LeonardoMFS/desafioWebBase/assets/90872650/6f0c2312-a4de-45ea-a79f-70d494342f57)

- Utilização de queries para interação com o banco de dados
  
![image](https://github.com/LeonardoMFS/desafioWebBase/assets/90872650/715e90b7-ad35-4d20-bf09-370959658b7f)




