### Documentation

### Getting Started

```
git clone https://github.com/karabaevas/betoola-hometask.git
cd betoola-hometask
```
### Build:
For Linux:
```
./gradlew build
```
For Windows
```
gradlew.bat build
```
Run App
```
./gradlew booRun
```
API description:
```
http://localhost:8080/swagger-ui/index.html
```
View contract file:
```
http://localhost:8080/v3/api-docs
```
Download contract file:
```
http://localhost:8080/v3/api-docs.yaml
```
### DB:
URL: jdbc:h2:mem:testdb
USER: SA
UI
```
http://localhost:8080/h2-console
```
CURL Example:
```
curl -X POST "http://localhost:8080/rest/exchange?currencyForSale=GBP&amountForSale=1000&targetCurrency=EUR"
```
