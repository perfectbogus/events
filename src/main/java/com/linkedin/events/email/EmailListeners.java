package com.linkedin.events.email;

import com.linkedin.events.customer.CustomerRegisteredEvent;
import com.linkedin.events.customer.CustomerRemovedEvent;
import com.linkedin.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
public class EmailListeners {

    private final EmailService emailService;

    @EventListener
    public void onRegisterEvent(CustomerRegisteredEvent event){
        emailService.sendRegisterEmail(event.getCustomer());
    }

    @EventListener
    public void onDeletedEvent(CustomerRemovedEvent event){
        emailService.sendCustomerRemovedEmail(event.getCustomer());
    }

    @EventListener
    public void onOrderCompletedEvent(OrderCompletedEvent event){
        emailService.sendOrderEmail(event.getOrder());
    }
}
