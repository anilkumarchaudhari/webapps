package com.spring.batch.batchapplication;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<InvalidLoginData, InvalidLoginData> {

	
    public Processor() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public InvalidLoginData process(InvalidLoginData item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("log data processed is "+item);
		return item;
	}

}
