# Livegoods House Rental Microservice Application

## About

This project is an application that utilizes Java microservice development to support the backend of a house rental platform. The platform features displaying and recommending hot-selling products, keyword searching

## Tools and Frameworks

- Spring Boot
- Spring Cloud
- MongoDB
- Docker
- Elasticsearch
- Redis
- Linux Virtual Machine setup and configuration

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
- Installed and configured `Docker` and `Registry` for the deployment of the project as an image

3. Build the project backend

- First, implement the following service modules in code:
  - Eureka server
  - Pojo Object: an object that stores the data information (id, url, time created) of an image, so that it can be passed into other functions
  - MongoDB service
  - Banner service: for displaying the images in a rolling (swiping) style
  - Commons service: use enum class for coding the request result (success, error) to improve readability and decouple the program

- Use `io.fabric8` in Maven to build and package Docker images of the project and send to the node servers

- Build spring cloud gateway service by configurations in the gateway module

### Part 2: Feature of Displaying Hot-selling Products

- Construct Pojo class, add the fields of: sales, city, and whether the city should be listed on the hot-selling interface

- Based on the city, pick 4 most hot-selling products (sort by descending `sales`). If there is fewer than 4 products for the current city, then fill in the slots with products from other cities

### Part 3: Feature of Hot-selling Products Recommendation

- The development of this feature is similar to the feature of displaying hot-selling products, but the difference is that the sorting mechanism is no longer based on descending sales, but on `recoSort`, which is a weight value calculated and sent by some potential data analysis result

### Part 4: Feature of Keyword Searching

- Query all the products' data from `MongoDB`, transfer the data to the form that is compatible to `Elasticsearch`, and upload data to `Elasticsearch` so as to support searching
- Use `HighlightBuilder` to display highlighted keyword in the search result
- Use `BoolQueryBuilder` to constrain the field (`city`) value that must be included and the fields (`title`, `houseType`, `rentType`) that are optional
- Add a `hasMore` field in the commons class, to indicate that given a max number of search result entries can be displayed in one page (provided by the frontend), whether there are more search results coming after the current page

### Part 5: Feature of Displaying a Product's Detailed Info

- Based on the information specified by frontend (in interface documentation), the service should return `Item` type instead of `LivegoodsResult` type

- Because the detailed information of products will not be constantly changing, consider using `Redis` to cache the data
