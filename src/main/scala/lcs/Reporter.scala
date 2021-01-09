package lcs

trait Reporter {

  def reportCondition(c: Condition): String = {
    var str : String = c.data.get.bits
    s"Condition:  $str"
  }

  def reportAction(p: Phenotype): String = {
    var str : String = p.data.get.bits
    s"Action:  $str"
  }

  def reportSet(s: List[ClassifierRule[Condition,Phenotype,Boolean]]): Unit = {
    s. foreach {c =>
      println(c.report())
    }
  }


  def sort : List[ClassifierRule[Condition,Phenotype,Boolean]] =>
    List[ClassifierRule[Condition,Phenotype,Boolean]] = {cls =>
    isort(cls).reverse
  }


  def isort : List[ClassifierRule[Condition,Phenotype,Boolean]] =>
    List[ClassifierRule[Condition,Phenotype,Boolean]] = {cls =>
    def insert(x: ClassifierRule[Condition,Phenotype,Boolean],
               xs: List[ClassifierRule[Condition,Phenotype,Boolean]]):
    List[ClassifierRule[Condition,Phenotype,Boolean]] = {
      xs match {
        case List() => List(x)
        case y :: ys => if (x.accuracy <= y.accuracy) x :: xs else y :: insert(x,ys)
      }
    }

    cls match {
      case List() => List()
      case x :: xs => insert(x,isort(xs))
    }
  }


}