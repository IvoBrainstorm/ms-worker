package mz.co.matavele.hrworker.resources;

import mz.co.matavele.hrworker.entities.Worker;
import mz.co.matavele.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/worker")
public class WorkerResource {


    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> workerList = repository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok(worker);
    }

}
