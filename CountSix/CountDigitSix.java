public class CountDigitSix {


  // main
  public static void main(String[] args) {
    System.out.println("countTarget isSuccess = " + (countTarget(57, 6) == 0));
    System.out.println("countTarget isSuccess = " + (countTarget(55, 6) == 0));
    System.out.println("countTarget isSuccess = " + (countTarget(1, 6) == 0));
    System.out.println("countTarget isSuccess = " + (countTarget(56, 6) == 1));
    System.out.println("countTarget isSuccess = " + (countTarget(66, 6) == 2));

    final int start = 123;
    final int end =   999;
    final int target = 6;


    System.out.println("isSuccess = " + (countTarget2(start, end, target) == countTarget(start, end, target)));
  }

  private static int countTarget(int start, int end, int target) {
    if (end < start) {
      return 0;
    }

    int count  = 0;

    for (int i = start; i <= end; i++) {
      count += countTarget(i, target);
    }

    System.out.println("target = " + target + ", count = " + count);
    return count;
  }

  private static int countTarget2(int start, int end, int target) {

    if (end < start) {
      return 0;
    }

    int prevCount = countTarget(start, target);
    int count = prevCount;

    for(int i = start + 1 ;  i<= end ;  i++){
      // xxxx9 -> xxx0
      if ( (i-1)%10 == 9 ) {
        prevCount = countTarget(i, target);
      }

      // count(i, target) = prevCount -1
      else if ( (i-1)%10 == target && i%10 != target ) {
        prevCount -= 1;
      }

      // count(i, target) = prevCount + 1
      else if ( (i-1)%10 != target && i%10 == target ) {
        prevCount += 1;
      }

      // count(i, target) = prevCount
      else {
        // don't change prevCount
      }
      count += prevCount;
    }

    System.out.println("target = " + target + ", count = " + count);
    return count;
  }

  private static int countTarget(int n, int target){
    int count = 0;

    while(n > 0){
      if( n % 10 == target){
        count++;
      }
      n = n / 10;
    }
    return count;
  }
}
