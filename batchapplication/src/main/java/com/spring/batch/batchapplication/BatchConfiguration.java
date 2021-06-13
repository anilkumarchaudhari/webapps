package com.spring.batch.batchapplication;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing

public class BatchConfiguration {
	
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory ,StepBuilderFactory stepBuilderFactory,
			    ItemReader<InvalidLoginData> itemReader,
			    ItemProcessor<InvalidLoginData,InvalidLoginData> itemProcessor ,ItemWriter<InvalidLoginData> itemWriter) {
		
		//build steps
		Step step =  stepBuilderFactory.get("ETL-file-load")
                          .<InvalidLoginData,InvalidLoginData>chunk(5)
                          .reader(itemReader)
                          .processor(itemProcessor)
                          .writer(itemWriter)
                          .build();
                          
		//build job and return 
		return jobBuilderFactory.get("ETL-Load")  //name for job
		                 .incrementer(new RunIdIncrementer()) //increments every time job runs
		                 .start(step) //can have may steps if have single the start as .flow().next()
		                 .build();
		
	}
	
	@Bean
	public FlatFileItemReader<InvalidLoginData>  itemReader(@Value("${csv.file.path}") Resource resource){
		System.out.println("Inside FlatfileReader "+resource);
		FlatFileItemReader<InvalidLoginData> flatFileItemReader=new FlatFileItemReader<>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setStrict(false);
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}
	
	@Bean
	public LineMapper<InvalidLoginData> lineMapper(){
		DefaultLineMapper<InvalidLoginData> defaultLineMapper=new DefaultLineMapper();
		
		DelimitedLineTokenizer  delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setDelimiter(",");
		delimitedLineTokenizer.setStrict(false);
		delimitedLineTokenizer.setNames(new String [] {"id","count","email","reason"});
		
		BeanWrapperFieldSetMapper<InvalidLoginData> fieldSetMapper= new BeanWrapperFieldSetMapper();
		fieldSetMapper.setTargetType(InvalidLoginData.class);
		
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultLineMapper;
	}

}
