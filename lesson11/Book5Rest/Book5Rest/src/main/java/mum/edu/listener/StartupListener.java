package mum.edu.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import mum.edu.repository.ApplicationRepository;

//@Component
public class StartupListener implements ApplicationListener<ContextStartedEvent>{

	@Autowired
	ApplicationRepository ApplicationRepository;
	
	@EventListener
	public  void onApplicationEvent(ContextStartedEvent event) { }



}
