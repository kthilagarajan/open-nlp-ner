# open-nlp-ner
Open NLP Name Entity Recognition for Organization Names


# Steps to run the application :

1. Clone the repository
2. Open netbeans and open the project
3. Do Maven Build with dependencies
4. Right click, project root and click on run.
5. Now, application is ready to server at http://localhost:2010/

# API Calls :

# To Train the existing model with new entries :
<br/>
POST http://localhost:2010/api/trainModel
<br/>
Request Body :
<br/>
<START:company> CompanyA <END> is bought by <START:company> CompanyB <END>
<br/>
Expected Output :
{
	status : true
}

# To find the organization name in a document :

POST http://localhost:2010/api/findOrgs
<br/>
Request Body :
<br/>
CompanyA is a very good competitor to CompanyB.
<br/>
Expected Output :
<br/>
{
	status : true,
	data : CompanyA, CompanyB
}
