package com.test.test.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class PythonService {
    public String runPythonScript(String category, String level) {
        try {
            // Update the path to your main.py script
            String scriptPath = "C:\\Users\\Uday Kiran\\Desktop\\hrai - yashwanth\\interview-main\\main.py";
            ProcessBuilder pb = new ProcessBuilder("python", scriptPath, category, level);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();

            // Print output for debugging
            System.out.println("Python Script Output: " + output.toString());

            return output.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Error running Python script\"}";
        }
    }
}
