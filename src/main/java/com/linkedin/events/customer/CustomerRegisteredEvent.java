package com.linkedin.events.customer;

import lombok.Data;

@Data
public class CustomerRegisteredEvent
{
    private final Customer customer;
}
