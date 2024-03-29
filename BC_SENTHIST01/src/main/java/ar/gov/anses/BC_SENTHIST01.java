package ar.gov.anses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@EnableBatchProcessing
@SpringBootApplication
public class BC_SENTHIST01 {

	private Logger logger =  LoggerFactory.getLogger(BC_SENTHIST01.class);

	@Autowired
	private Job cruce;

	@Autowired
	private JobLauncher jobLauncher;

	@PostConstruct
	private void setUp() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
		logger.info("El aplicativo ha sido desplegado exitosamente");
		jobLauncher.run(cruce, new JobParametersBuilder().toJobParameters());
	}
	public static void main(String[] args) {
		SpringApplication.run(BC_SENTHIST01.class, args);


	}

}
