# nginx

Изменение файла nginx.conf для задачи "Прокси на nginx" 

```
http {
    server {
        listen       80;
        server_name  localhost;

        location / {
           proxy_pass http://localhost:8080;
        }

        location /signin {
            try_files $uri $uri/ /signin.html;
        }
    }
}
```