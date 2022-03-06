package mz.co.matavele.hrpayroll.services;

import mz.co.matavele.hrpayroll.entities.Payment;
import mz.co.matavele.hrpayroll.entities.Worker;
import mz.co.matavele.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){
        Worker worker = workerFeignClient.getById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
