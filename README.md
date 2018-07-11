# open-nlp-ner
Open NLP Name Entity Recognition for Organization Names


Steps to run the application :

1. Clone the repository
2. Open netbeans and open the project
3. Do Maven Build with dependencies
4. Right click, project root and click on run.
5. Now, application is ready to server at http://localhost:2010/

API Calls :

To Train the existing model with new entries :

POST http://localhost:2010/api/trainModel
Request Body :
<START:company> CompanyA <END> is bought by <START:company> CompanyB <END>

Expected Output :
{
	status : true
}

To find the organization name in a document :

POST http://localhost:2010/api/findOrgs
Request Body :
CompanyA is a very good competitor to CompanyB.

Expected Output :

{
	status : true,
	data : CompanyA, CompanyB
}
