# Employee Information System-REST API

## Description
The goal of this assessment project is to develop a simple RESTful API to retrieve and display data residing employee data in an Oracle database(AWS cloud). 
To import a project as a general project:

##Secitons
- [Techonlogy Overview](#technology-overview)
- [Imorting using Zip file(Preferred)](#importing-using-zip-file(prefered))
- [Importing project using GIT import in Eclipse IDE](#importing-project-using-git-import-in-eclipse-ide)
- [Run Application](#run-application)
- [List of RESTful API supported](#list-of-restfull-api-supported)
- [UserAuth Credentials](#userAuth-credentials)

##Techonlogy Overview

- Java Spring Boot Framework is used to create this RestFull API service.
- Apache Maven is used to manage the libraries and building of project.
- Hibernate ORM with JPA implementations is used to access DB.
- Spring BAsic Auth is used to provide authentication
 

## Imorting using Zip file.
### !! The repository has sub module project!!
* Download the zip file from the git repository.
*Extract the zip file.
* Open IDE,Click `Import->Import Projects from File System`.
* Browse through the Imported folder and select `tds` folder inside `tds-assessment`. (`tds-assessment-master\tds`),click `Finish`.
* Wait for maven finsih loading the libraries.

## Importing project using GIT import in Eclipse IDE
### !! The repository has sub module project!!
* Click `File > Import`.
* In the `Import wizard`:
  * Click `Git > Projects from Git`. Click Next.
  * Click `Clone URI` and click Next.
  * In the Source Git Repository window, in the URI field, enter an existing `Git repository URL`,and click Next.
  * In the Local Destination window,click `Browse to select the location`.
  * In the Select a wizard to use for `importing projects window`, `Import as general project` is selected by `default`. Click Next.
  * In the `Import Projects window`,click `Finish`.
  * Click `file-> open projectes from files system or archive`.select the imported folder `tds-assessment` as import source,`tds-assessment\tds` in folder.Click finish.
  *tds project while be imported into IDE.
  
## Run Application
*  `Run` the `EmployeeInformationSystemApplication.class` which contains the main class in tds.

  


## UserAuth Credentials
- Type= Basic Auth
- username= user
- password= password

## List of RESTful API supported

- http://localhost:8080/GET/departments
- http://localhost:8080/GET/badges
- http://localhost:8080/GET/badges/active
- http://localhost:8080/GET/badges?badge_number=[badge_number]
- http://localhost:8080/GET/job_titles
- http://localhost:8080/GET/job_titles/:[department_name]
- http://localhost:8080/GET/employees
- http://localhost:8080/GET/employees/active
- http://localhost:8080/GET/employees?department_name=[department_name]

## Output ScreenShots

Have captured output of various outputs and errors.
* [Output](https://github.com/koushikraj23/tds-assessment/tree/master/tds/src/main/resources/static/image/output)

