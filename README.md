### This is ReadMe Placeholder

Command line
mvn -clean
mvn -install

mvn test

mvn test -Dcucumber.filter.tags="@AddToCart"

mvn test -Dcucumber.filter.tags="@AddToCart" -Dbrowser=edge

jenkins
test -Dcucumber.filter.tags="@"$tags"" -Dbrowser="$browser"