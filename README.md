# TextSummarizerAI

A simple **extractive text summarizer** written in Java using Maven.  
It identifies key sentences based on word frequency scoring and generates a concise summary.

---

## Features
- Pure Java implementation (no heavy ML framework required)
- Preprocessing (lowercasing, stopword removal, punctuation cleanup)
- Sentence scoring using word frequency weights
- Works offline

---

## Requirements
- **JDK 17+**
- **Maven**

---

## Build

Run the following command to build the project:

```bash
mvn clean package
```
## Project structure

```
TextSummarizerAI/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/summarizer/
│   │   │       ├── Main.java
│   │   │       ├── Preprocessor.java
│   │   │       ├── SentenceScorer.java
│   │   │       ├── Summarizer.java
│   │   │       └── Utils.java
│   │   └── resources/
│   │       └── stopwords.txt
├── pom.xml
└── README.md

```

## Notes

- This is a lightweight extractive summarizer intended for educational use.
- You can replace the simple tokenizer / splitter with a production NLP library for better results.
