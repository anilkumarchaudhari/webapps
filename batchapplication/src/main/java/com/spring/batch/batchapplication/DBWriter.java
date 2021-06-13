package com.spring.batch.batchapplication;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBWriter implements ItemWriter<InvalidLoginData> {

	@Autowired
	private InvalidLoginRepository invalidLoginRepository;
	@Override
	public void write(List<? extends InvalidLoginData> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("List of data processed "+items+" chunk size "+items.size());
		invalidLoginRepository.saveAll(items);
	}

}
