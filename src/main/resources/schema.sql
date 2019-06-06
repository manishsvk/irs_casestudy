create table job
(
   jobId varchar(10) not null,
   jobName varchar(50) not null,
   jobDescr varchar(100) not null,
   location varchar(20) not null,
   companyName varchar(20) not null,
   minExperience varchar(10) not null,
   skills varchar(100) not null,
   status varchar(10) not null,
   submittedBy varchar(50) not null,
   
   primary key(jobId)
);

create table jobapplication
(
   applicationId varchar(10) not null,
   jobId varchar(10) not null,
   applicantName varchar(50) not null,
   applicationStatus varchar(20) not null,
   linkedinUrl varchar(100) not null,
   resumeLocation varchar(100) not null,
   score varchar(5) not null,
   
   primary key(applicationId)
);