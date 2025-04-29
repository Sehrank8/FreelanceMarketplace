package com.FreelanceMarketplace.api.Config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String EVALUATION_QUEUE = "freelancer-evaluation-queue";
    public static final String DLQ_QUEUE = "freelancer-evaluation-dlq";
    public static final String EVALUATION_EXCHANGE = "freelancer-evaluation-exchange";
    public static final String DLQ_EXCHANGE = "freelancer-evaluation-dlq-exchange";
    public static final String EVALUATION_ROUTING_KEY = "freelancer-evaluation-routing-key";
    public static final String DLQ_ROUTING_KEY = "freelancer-evaluation-dlq-routing-key";

    @Bean
    public Queue evaluationQueue() {
        return QueueBuilder.durable(EVALUATION_QUEUE)
                .withArgument("x-dead-letter-exchange", DLQ_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", DLQ_ROUTING_KEY)
                .build();
    }

    @Bean
    public Queue deadLetterQueue() {
        return QueueBuilder.durable(DLQ_QUEUE).build();
    }

    @Bean
    public TopicExchange evaluationExchange() {
        return new TopicExchange(EVALUATION_EXCHANGE);
    }

    @Bean
    public TopicExchange deadLetterExchange() {
        return new TopicExchange(DLQ_EXCHANGE);
    }

    @Bean
    public Binding evaluationBinding() {
        return BindingBuilder.bind(evaluationQueue())
                .to(evaluationExchange())
                .with(EVALUATION_ROUTING_KEY);
    }

    @Bean
    public Binding dlqBinding() {
        return BindingBuilder.bind(deadLetterQueue())
                .to(deadLetterExchange())
                .with(DLQ_ROUTING_KEY);
    }
}
