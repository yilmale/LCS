//import xcs._

import lcs._

object LCSMain extends App {

    /*
    var ucs : SupervisedLCS  = new SupervisedLCS()
    ucs.run(new MultiplexProblem(2000))
    ucs.report(cl => (cl.fitness > 0.8) && (cl.accuracy > 0.8))
    */

    /*
    var problem = new LCSOmegaProblem(10000)
    var ucs : SupervisedLCS  = new SupervisedLCS()
    ucs.run(problem)
    ucs.report(cl => (cl.fitness > 0.5) && (cl.accuracy > 0.5))
  */

    /*
    var uslcs = new UnSupervisedLCS with Reporter
    var problem = new LCSOmegaProblem(15000)
    var experiments : Int = 5
    var i : Int = 0
    do {
      println("Experiment " + i + ":")
      uslcs.run(problem)
      uslcs.report(cl => (cl.fitness >= 0.5))
      problem.reset
      i += 1
      println("----------------------")
    } while (i < experiments)

  */


    /*
    var problem = new LCSAUProblem(15000)
    var uslcs : UnSupervisedLCS with Reporter = new UnSupervisedLCS with Reporter
    uslcs.run(problem)
    var results = uslcs.report(cl => (cl.fitness > 0.5))
    println("--------Sorted Results ------ ")
    uslcs.sort(results) foreach { cl =>
      println(cl.report())
    }

    */

    var problem = new LCSAUProblem(10000)
    var ucs : SupervisedLCS with Reporter = new SupervisedLCS with Reporter
    ucs.run(problem)
    var results = ucs.report(cl => (cl.fitness > 0.5) && (cl.accuracy > 0.7))
    println("--------Sorted Results ------ ")
    ucs.sort(results) foreach {cl =>
      println(cl.report())
    }


    /*
      var uslcs : UnSupervisedLCS with Reporter = new UnSupervisedLCS with Reporter {}
      uslcs.run(new MultiplexProblem(50000))
      var results = uslcs.report(cl => (cl.fitness > 0.5))
      println("--------Sorted Results ------ ")
      uslcs.sort(results) foreach {cl =>
        println(cl.report())
      }

    */

    /*
      var s1: String = "1122"
      var s2: String = "1122"

      var s3: String = "1122"
      var s4: String = "1122"

      var S1 : Set[Tuple3[String,String,Double]] = Set()
      S1 = S1 + Tuple3(s1,s2,0.5)
      S1 = S1 + Tuple3(s3,s4,0.7)

      println(S1)

    */

}
