import xcs._
//import lcs._

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

  var uslcs : UnSupervisedLCS with Reporter = new UnSupervisedLCS with Reporter {}
  var problem = new LCSOmegaProblem(15000)
  uslcs.run(problem)
  var results = uslcs.report(cl => (cl.fitness >= 0.8))
  println("--------Sorted Results ------ ")
  uslcs.sort(results) foreach {cl =>
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

}
