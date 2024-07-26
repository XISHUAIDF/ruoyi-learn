pipeline {
    agent any

    // 定义环境变量
    environment {
        // Docker 镜像的名称和版本
        DOCKER_IMAGE = 'ruoyi'
        DOCKER_TAG = 'latest'
        // Git 仓库地址
        GIT_REPO = 'https://github.com/XISHUAIDF/ruoyi-learn.git'
        // Git 分支
        GIT_BRANCH = 'main'
    }

    stages {
        stage('Clone Repository') {
            steps {
                // 从 Git 仓库克隆代码
                git branch: "${env.GIT_BRANCH}", url: "${env.GIT_REPO}"
            }
        }

        stage('Build Docker Image') {
            steps {
                // 使用 Docker 构建镜像
                script {
                    docker.build("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}")
                }
            }
        }

}

  post {
        always {
            // 清理工作区
            cleanWs()
        }
    }

}


