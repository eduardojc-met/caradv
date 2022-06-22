#!/usr/bin/env groovy
// Documentation: https://confluence.alm.europe.cloudcenter.corp/display/C3AL/Pipelines+Introduction
@Library(['scf-pipes-shared-library',
'jenkins-shared-utils' ,
'scq-pipeline-library']) _

def config = readYaml text: """
---
DOMAIN: 'SCQ'
PROJECT_NAME: 'scq-car-advisor'
APP_NAME: 'car-advisor'
APP_TYPE: 'MavenDockerHelm'
DEPLOYMENT_TYPE: 'EKS'
PACKAGE_FORMAT: 'jar'
CB_MASTER: 'scq-03-pro'
BLUEGREEN: 'OFF'
DEBUG_MODE: 1
LOG_LEVEL: 'INFO'
DOCKER_IMAGE: 'https://github.alm.europe.cloudcenter.corp/scq-car-advisor/docker-java11-image'
HELM_TEMPLATE: 'https://github.alm.europe.cloudcenter.corp/scq-car-advisor/helm-java-base'
HELM_AUTO_ROLLBACK: '0'
HELM_FORCE: '0'
ECR_REGISTRY: '1'
BUILD_PROXY: 1
TECH_VERSION: 11
"""   
      
config.keySet().each{
  env."${it}" = config[it]
}

"${pipelineForTechBranch(env)}"(config)
 
 


