package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	// Get an instance into a service
	@Autowired
	TopicRepository topicRepository;
	
	/*
	List<Topic> topics = new ArrayList<Topic>
							(Arrays.asList
								(
								new Topic("spring", "Spring Framework", "Spring Framework Description"), 
								new Topic("java", "Core Java", "Core Java Description"), 
								new Topic("javascript", "Javascript", "Javascript Description")
								)
							);
	*/
	
	public List<Topic> getTopics() {
		//return this.topics;
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		//return this.topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		/*
		for(int i = 0; i < topics.size(); i++) {
			Topic t = this.topics.get(i);
			if(t.getId().equalsIgnoreCase(id)) {
				topics.set(i, topic);
				return;
			}
		}
		*/
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		/*
		for(int i = 0; i < topics.size(); i++) {
			Topic t = this.topics.get(i);
			if(t.getId().equalsIgnoreCase(id)) {
				topics.remove(i);
				return;
			}
		}
		*/
		topicRepository.delete(id);
	}
}
