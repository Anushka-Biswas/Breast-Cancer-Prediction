import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BreastCancerPrediction {
    
    // Method to create the dataset
    public static List<double[]> createDataSet() {
        List<double[]> dataSet = new ArrayList<>();
        
        // Add observations to the dataset
        dataSet.add(new double[]{17.99, 10.38, 122.8, 1001, 0.1184, 0.2776, 0.3001, 0.1471, 0.2419, 0.07871, 1.095, 0.9053, 8.589, 153.4, 0.006399, 0.04904, 0.05373, 0.01587, 0.03003, 0.006193, 25.38, 17.33, 184.6, 2019, 0.1622, 0.6656, 0.7119, 0.2654, 0.4601, 0.1189, 1});
        dataSet.add(new double[]{20.57, 17.77, 132.9, 1326, 0.08474, 0.07864, 0.0869, 0.07017, 0.1812, 0.05667, 0.5435, 0.7339, 3.398, 74.08, 0.005225, 0.01308, 0.0186, 0.0134, 0.01389, 0.003532, 24.99, 23.41, 158.8, 1956, 0.1238, 0.1866, 0.2416, 0.186, 0.275, 0.08902, 0});
        dataSet.add(new double[]{19.69, 21.25, 130, 1203, 0.1096, 0.1599, 0.1974, 0.1279, 0.2069, 0.05999, 0.7456, 0.7869, 4.585, 94.03, 0.00615, 0.04006, 0.03832, 0.02058, 0.0225, 0.004571, 23.57, 25.53, 152.5, 1709, 0.1444, 0.4245, 0.4504, 0.243, 0.3613, 0.08758, 1});
        dataSet.add(new double[]{11.42, 20.38, 77.58, 386.1, 0.1425, 0.2839, 0.2414, 0.1052, 0.2597, 0.09744, 0.4956, 1.156, 3.445, 27.23, 0.00911, 0.07458, 0.05661, 0.01867, 0.05963, 0.009208, 14.91, 26.5, 98.87, 567.7, 0.2098, 0.8663, 0.6869, 0.2575, 0.6638, 0.173, 1});
        dataSet.add(new double[]{20.29, 14.34, 135.1, 1297, 0.1003, 0.1328, 0.198, 0.1043, 0.1809, 0.05883, 0.7572, 0.7813, 5.438, 94.44, 0.01149, 0.02461, 0.05688, 0.01885, 0.01756, 0.005115, 22.54, 16.67, 152.2, 1575, 0.1374, 0.205, 0.4, 0.1625, 0.2364, 0.07678, 0});
        dataSet.add(new double[]{12.45, 15.7, 82.57, 477.1, 0.1278, 0.17, 0.1578, 0.08089, 0.2087, 0.07613, 0.3345, 0.8902, 2.217, 27.19, 0.00751, 0.03345, 0.03672, 0.01137, 0.02165, 0.005082, 15.47, 23.75, 103.4, 741.6, 0.1791, 0.5249, 0.5355, 0.1741, 0.3985, 0.1244, 1});
        dataSet.add(new double[]{18.25, 19.98, 119.6, 1040, 0.09463, 0.109, 0.1127, 0.074, 0.1794, 0.05742, 0.4467, 0.7732, 3.18, 53.91, 0.004314, 0.01382, 0.02254, 0.01039, 0.01369, 0.002179, 22.88, 27.66, 153.2, 1606, 0.1442, 0.2576, 0.3784, 0.1932, 0.3063, 0.08368, 0});
        dataSet.add(new double[]{13.71, 20.83, 90.2, 577.9, 0.1189, 0.1645, 0.09366, 0.05985, 0.2196, 0.07451, 0.5835, 1.377, 3.856, 50.96, 0.008805, 0.03029, 0.02488, 0.01448, 0.01486, 0.005412, 17.06, 28.14, 110.6, 897, 0.1654, 0.3682, 0.2678, 0.1556, 0.3196, 0.1151, 1});
        dataSet.add(new double[]{13, 21.82, 87.5, 519.8, 0.1273, 0.1932, 0.1859, 0.09353, 0.235, 0.07389, 0.3063, 1.002, 2.406, 24.32, 0.005731, 0.03502, 0.03553, 0.01226, 0.02143, 0.003749, 15.49, 30.73, 106.2, 739.3, 0.1703, 0.5401, 0.539, 0.206, 0.4378, 0.1072, 0});
        dataSet.add(new double[]{12.46, 24.04, 83.97, 475.9, 0.1186, 0.2396, 0.2273, 0.08543, 0.203, 0.08243, 0.2976, 1.599, 2.039, 23.94, 0.007149, 0.07217, 0.07743, 0.01432, 0.01789, 0.01008, 15.09, 40.68, 97.65, 711.4, 0.1853, 1.058, 1.105, 0.221, 0.4366, 0.2075, 1});
        
        return dataSet;
    }
    
    // Method to calculate Euclidean distance
    public static double euclideanDistance(double[] point1, double[] point2) {
        double sum = 0.0;
        for (int i = 0; i < point1.length - 1; i++) {
            sum += Math.pow(point1[i] - point2[i], 2);
        }
        return Math.sqrt(sum);
    }
    
    // Method to predict class label using KNN algorithm
    public static String predictClass(List<double[]> dataSet, double[] newPoint, int k) {
        double[][] distances = new double[dataSet.size()][2];
        
        // Calculate distances between new point and all points in the dataset
        for (int i = 0; i < dataSet.size(); i++) {
            distances[i][0] = euclideanDistance(dataSet.get(i), newPoint);
            distances[i][1] = dataSet.get(i)[dataSet.get(i).length - 1];
        }
        
        // Sort distances
        java.util.Arrays.sort(distances, (a, b) -> Double.compare(a[0], b[0]));
        
        // Count class occurrences among nearest k points
        int[] classCounts = new int[2];
        for (int i = 0; i < k; i++) {
            int label = (int) distances[i][1];
            classCounts[label]++;
        }
        
        // Return class label with highest occurrence among nearest k points
        return (classCounts[0] > classCounts[1]) ? "Benign" : "Malignant";
    }
    
    // Method to calculate accuracy
    public static double calculateAccuracy(int truePositives, int trueNegatives, int falsePositives, int falseNegatives) {
        return (double) (truePositives + trueNegatives) / (truePositives + trueNegatives + falsePositives + falseNegatives);
    }
    
    // Method to calculate precision
    public static double calculatePrecision(int truePositives, int falsePositives) {
        return (double) truePositives / (truePositives + falsePositives);
    }
    
    // Method to calculate recall
    public static double calculateRecall(int truePositives, int falseNegatives) {
        return (double) truePositives / (truePositives + falseNegatives);
    }
    
    // Method to calculate F1-score
    public static double calculateF1Score(double precision, double recall) {
        return 2 * ((precision * recall) / (precision + recall));
    }
    	
    public static void main(String[] args) {
        List<double[]> dataSet = createDataSet();
	Scanner scanner = new Scanner(System.in);
        
        // New data point for prediction
        double[] newPoint = {15, 25, 100, 500, 0.1, 0.2, 0.3, 0.1, 0.2, 0.07, 0.3, 1.5, 2, 20, 0.007, 0.05, 0.06, 0.01, 0.02, 0.005, 15, 30, 110, 700, 0.16, 0.5, 0.5, 0.2, 0.4, 0.1};
        
        // Prompt the user to input the value of K
        System.out.print("Enter the value of K: ");
        int k = scanner.nextInt();
        
        // Predict class label
        String predictedClass = predictClass(dataSet, newPoint, k);
        
        // Print predicted class label
        System.out.println("Predicted class: " + predictedClass);

	// Calculate performance metrics
        int truePositives = 0, trueNegatives = 0, falsePositives = 0, falseNegatives = 0;
        for (double[] observation : dataSet) {
            String trueClass = observation[observation.length - 1] == 1 ? "Malignant" : "Benign";
            String predicted = predictClass(dataSet, observation, k);
            if (predicted.equals("Malignant") && trueClass.equals("Malignant")) {
                truePositives++;
            } else if (predicted.equals("Benign") && trueClass.equals("Benign")) {
                trueNegatives++;
            } else if (predicted.equals("Malignant") && trueClass.equals("Benign")) {
                falsePositives++;
            } else if (predicted.equals("Benign") && trueClass.equals("Malignant")) {
                falseNegatives++;
            }
        }
        
        double accuracy = calculateAccuracy(truePositives, trueNegatives, falsePositives, falseNegatives);
        double precision = calculatePrecision(truePositives, falsePositives);
        double recall = calculateRecall(truePositives, falseNegatives);
        double f1Score = calculateF1Score(precision, recall);
        
        // Print performance metrics
        System.out.println("Accuracy: " + accuracy);
        System.out.println("Precision: " + precision);
        System.out.println("Recall: " + recall);
        System.out.println("F1 Score: " + f1Score);
        
    }
}
