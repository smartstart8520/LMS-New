package org.example.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.example.model.Lms;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class LmsService {
    public String createCRUD(Lms crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("user").document(crud.getDocumentId()).set(crud);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Lms getCRUD(String id) throws ExecutionException, InterruptedException{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("user").document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();
        Lms lms;
        if (documentSnapshot.exists()){
            lms = documentSnapshot.toObject(Lms.class);
            return lms;
        }
        return null;
    }
    public String updateCRUD(Lms student) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("user").document(student.getDocumentId()).set(student);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCRUD(String id){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("user").document(id).delete();
        return "Successfully deleted" + id;
    }
}
