# TestPod
Automated Evaluation Of Essay-Based Questions Based On Natural Language Processing (AI)

## Abstract

- One of the most crucial aspects of a teaching faculty is to correct the answer sheets
- With a curriculum driven by tests and scoring, examinations have stood as the backbone of the education industry.
- Teaching faculty spend an enormous amount of time for verification and assigning the scores to each student. The following action is a limitation as the faculty can focus on other aspects of teaching and enriching the students.
- The application focuses on a novel methodology to automate the correction for subjective-based questions and answers using NLP Techniques.

## Concepts Used

1. Natural Language Processing
2. Fuzzy Logic

## Algorithm

- The answer is broken down into
sentences, using the delimiter (.)
- The broken array of sentences is
parsed using POS sentence tagging
- The sentences are mapped to the
token as <POS Tag, Token> mapping
- For each sentence, the sentence is
iterate through the resources
provided to the model for analysis and
evaluation
- An intermediate output in the form
of an array of boolean values are generated for further processing by rule-based NLP Techniques
- The intermediate output is fed to a fuzzifier to generate fuzzy sets for
discrete evaluation and using hierarchical-based valuation
- Finally, the score for the submitted answer is generated using the
weighted average technique from the discrete score from the fuzzy sets

## Application Workflow

- The application is built using Apache OpenNLP, an NLP tool built for Java
applications
- The major stakeholder of the application are the faculty and the
student. The faculty feeds the question and the respective answer key to
the application
- The uploaded questions and answers are processed
respectively
- Every test has a test ID, a unique primary key to map the
question with the answer.
- The questions for the test are saved in
RDBMS. The answers are processed using the core NLP package in the
application
- The answer key is processed, tokenized, and POS tagged. The
structured answer is stored in a text file along with the metadata of the
file
- When a student attempts the exam, the answers are processed,
tokenized and POS tagged. The structured answer script saved as a file is
decoded to proper data structures with the help of metadata
- A container (Java bean) is created to save the information of the structure. Two
containers, one for faculty and another for a student are created
- The student container is passed to the faculty container to find the similarity index
matrix
- The matrix is de-fuzzified using fuzzy logic and appropriate marks
are allocated for each question using weighted average method
