package com.example.services;

import org.springframework.stereotype.Service;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.Builder;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Service
public class GCPService {
	
	public void checkConnection(){
		Storage storage = StorageOptions.getDefaultInstance().getService();
		System.out.println("Connected to Google cloud storage. Is storage object null ?: "+(storage == null));
	}
	
	public void createBucket(){

		try{
			
			Storage storage = StorageOptions.getDefaultInstance().getService();
			String bucketName = "ecmspace-bucket-1";  // "my-new-bucket";
			Builder builder = BucketInfo.newBuilder(bucketName);
			Bucket bucket = storage.create(builder.build());
			System.out.println("created bucket.."+bucket.getName());
			  
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
