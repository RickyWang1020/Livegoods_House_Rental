# Livegoods House Rental Microservice Application

## About

## Tools and Frameworks

- Spring boot
- MongoDB
- Docker
- Linux Virtual Machine setup and configuration

## Folder Structure

## Workflow

### Part 1: Preparations

1. Deploy frontend environment

- Install Node.js
- The frontend is vueJS, so we can just use `cnpm install` to install all needed modules, and use `cnpm start` to start the frontend service

2. Deploy backend service

- `MongoDB` as data storage, `FastDFS` as file storage server, `ElasticSearch` as the search engine
- Create CentOS VMs in VirtualBox, set up static IP and connect to the internet, download Docker and Nginx
- Configurations and settings of 3 VMs for different purposes:
  - node1 (192.168.57.3): FaseDFS Tracker, Elasticsearch
  - node2 (192.168.58.3): FastDFS Storage, Nginx, MongoDB
  - node3 (192.168.56.101): Docker
- Use FastDFS to upload images that will be used for front-end display
- Installed and configured `Docker` and `Registry` for deployment of the project as an image

3. Build the project backend

- First, implement the following services in code:
  - Eureka server
  - Pojo Object: an object that stores the data information of an image, so that it can
  - MongoDB service
  - Banner service
  - Commons service: use enum class for coding the request result (success, error) to improve readability and decouple the program

- Use ?? to package Docker images and send to the node servers

- Build spring cloud gateway service

### Part 2: Feature of Displaying Hot-selling Products

1. Business Requirement Documentation

- Construct Pojo class, add the fields of: sales, city, whether the city should be listed on the hot-selling interface

- Based on the city, pick 4 most hot-selling products. If there is fewer than 4 products, then fill in the slots with products from other cities

### Part 3: Feature of Hot-selling Products Recommendation
