package com.test.test.service;

import com.test.test.model.JobDescription;
import com.test.test.model.UserResponseAnalysis;
import org.springframework.stereotype.Service;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class NLPService {

    private final String HUGGINGFACE_API_URL = "https://api-inference.huggingface.co/models/gpt2";
    private final String HUGGINGFACE_API_KEY = "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"; // Replace with your actual API key

    public String analyzeJobDescription(JobDescription jobDescription) {
        String description = jobDescription.getDescription();
        try {
            String jsonResponse = callHuggingFace(description);
            JSONArray choices = new JSONArray(jsonResponse);
            String feedback = choices.getJSONObject(0).getString("generated_text");
            String nextQuestion = "Can you elaborate more on this skill?";

            // Extract relevant part of the feedback
            feedback = extractRelevantFeedback(feedback);

            return "Feedback: " + feedback + "\nNext Question: " + nextQuestion;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error while analyzing job description.";
        }
    }

    private String callHuggingFace(String prompt) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String requestBody = new JSONObject()
                .put("inputs", prompt)
                .put("options", new JSONObject().put("max_length", 150))
                .toString();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HUGGINGFACE_API_URL))
                .header("Authorization", "Bearer " + HUGGINGFACE_API_KEY)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private String extractRelevantFeedback(String feedback) {
        // Split feedback by sentences and return the first relevant sentence
        String[] sentences = feedback.split("\\.\\s+");
        if (sentences.length > 0) {
            return sentences[0];
        }
        return feedback;
    }

    public UserResponseAnalysis analyzeResponse(String response) throws IOException, InterruptedException {
        UserResponseAnalysis analysis = new UserResponseAnalysis();
        analysis.setContent(response);

        String jsonResponse = callHuggingFace(response);
        JSONArray choices = new JSONArray(jsonResponse);
        String feedback = choices.getJSONObject(0).getString("generated_text");

        // Extract relevant part of the feedback
        feedback = extractRelevantFeedback(feedback);

        analysis.setProficiencyLevel("N/A");
        analysis.setFeedback(feedback);

        return analysis;
    }
}
