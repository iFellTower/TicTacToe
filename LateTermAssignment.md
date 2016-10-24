## Status of Late Term Assignment


1. The code base is stored in source control system on GitHub from early start of the project (the teacher should be able to track the history of the project from the creation of the very first file).
  - Done
2. The system is set up with automatic build script.
  - Done
3. The build script runs all unit tests.
  - Done
4. The output is a deployable or executable artifact, such as a jar/war or equivalent.
  - Unfinished
5. The build script has deploy/install target that deploys the executable outside of the working directory or on external server.
  - Update later
6. The business logic should be coded using Test Driven Development.
  - Update later
7. The code should be loosely coupled and follow good object oriented design practices.
  - Update later
8. Documentation uses Markdown syntax.
  - WIP  
9. Use Automated Continuous Integration Server (e.g. Travis).
  - Done

Optional:

1. More build targets (0,5 point per item, never more than 1 for this part) here are examples of build targets.
  - Code coverage and other code inspections. Report or other kind of result must be available outside of the build machine after each run.
  - Integrate database
  - Documentation is converted to another format (e.g PDF or Html) and is easily accessible outside of the build machine after each run.
2. Run focused integration or End-to-end tests (e.g. Selenium). It is necessary to run this on external staging server (e.g. Heroku). To run integration test the application needs to connect to external system e.g. database. To run end-to-end test the system needs to have GUI (e.g. webUI). (1 point)
3. Use feature branches and pull request for all features. It must be clear that this workflow was used the whole time and that the team was using reviews before accepting pull-requests. (1 point)
4. Continuous Delivery. For each code change the CI server runs these steps:
  - Run build script (all targets)
  - Run unit and integration tests (if you have integration tests)
  - Deploy on staging and run End-to-end tests.
  - Deploy to production server.
  - Only continue next step if previous step is success
  - Generate feedback to developer
5. Something else ... Surprise me !!!
