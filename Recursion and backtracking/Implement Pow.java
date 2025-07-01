Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

Examples:

Input: b = 3.00000, e = 5
Output: 243.00000
Input: b = 0.55000, e = 3
Output: 0.16638
Input: b = -0.67000, e = -7
Output: -16.49971
Constraints:

-100.0 < b < 100.0
-109 <= e <= 109
Either b is not zero or e > 0.
-104 <= be <= 104




  //Back-end complete function Template for Java
class Solution {
    double power(double b, int e) {
         // If the exponent is negative, compute the reciprocal of the base
        // raised to the positive exponent
        if (e < 0) {
            return 1.0 / power(b, Math.abs(e));
        }
        
        
        // Base case: any number raised to the power of 0 is 1
        if (e == 0) {
            return 1.0;
        }

       

        // Recursively compute the power for half of the exponent
        double temp = power(b, e / 2);
        temp = temp *temp;
        if(e % 2 != 0 ) 
        {
            return b* temp;
        }
        // If the exponent is even, simply square the half power
        else {
            return temp;
        }
    }
}
