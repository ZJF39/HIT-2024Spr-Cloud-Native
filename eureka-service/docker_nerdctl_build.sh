#!/bin/bash 
 
docker_registry=registry.cn-hangzhou.aliyuncs.com 
 
service_list="eureka-service gateway-service product-service product-client" 
service_list=${1:-${service_list}} 
work_dir=$PWD 
 
cd $work_dir 
#mvn clean package -Dmaven.test.skip=true 
 
for service in $service_list; do 
   cd $work_dir/$service 
   image_name=$docker_registry/my-stock/${service} 
   echo ${image_name} 
   nerdctl build -t ${image_name} . 
   nerdctl push ${image_name} 
done 