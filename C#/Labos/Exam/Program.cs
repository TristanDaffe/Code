
namespace Exam {
    public static class Program {
        public static void Main(string[] args) {
            string[] a = {"un", "deux", "trois"};
            AChoixMultiples test = new AChoixMultiples("énoncé", 10, new HashSet<string>(a));
            Console.WriteLine(test);

            int b = 4;
            int c = 10;
            
            Console.WriteLine((double)b / c* 100.0 );
        }
    }
}