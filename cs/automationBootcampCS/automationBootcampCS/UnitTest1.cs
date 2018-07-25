using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace automationBootcampCS
{
    [TestClass]
    public class HelloWorld
    {
        [TestMethod]
        public void WriteHelloWorld()
        {
            Console.WriteLine("Hello World!");
        }
    }
}