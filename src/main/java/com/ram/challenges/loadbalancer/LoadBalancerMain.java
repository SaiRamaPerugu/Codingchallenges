package com.ram.challenges.loadbalancer;

public class LoadBalancerMain {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer(80);
        while(true) {
            loadBalancer.start();
        }
    }
}
