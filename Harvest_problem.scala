import scala.io.StdIn._
object Harvest_problem {
  def main(args: Array[String]): Unit = {
    val harvestTable= Array.ofDim[ Float](5, 8)
    var max : Float=0
    var min : Float=0
    var range : Float=0
    var average : Float=0
    var medium : Float=0
    var total : Float=0
    val dayPerWeek=7
    val weekPerMonth=4
    val d=dayPerWeek*weekPerMonth

    for( m <-1 to weekPerMonth){
      for(n <- 1 to dayPerWeek){
        println("Enter the harvest amount of tea in "+ m + " week "+ n + " day:")
        var h=readInt()
        harvestTable(m)(n)=h;
        total=total+h
      }
    }

    max=harvestTable(1)(1)
    min=harvestTable(1)(1)

    println("")
    for(a<-1 to weekPerMonth){
      print("Week " + a + " harvest amount- | ")

      for(b<- 1 to dayPerWeek){
        print(harvestTable(a)(b)+"  |  ");

      }
      println("")
    }


    println("")
    for(a<-1 to weekPerMonth){
      for(b<- 1 to dayPerWeek){
        if(max< harvestTable(a)(b)) {
          max=harvestTable(a)(b)
        }
      }
    }
    println("Maximum harvest amount is: "+ max)
    


    for(a<-1 to weekPerMonth){
      for(b<- 1 to dayPerWeek){
        if(min> harvestTable(a)(b)) {
          min=harvestTable(a)(b)
        }
      }
    }

    println("Minimum harvest amount is: "+ min)

    range=max-min
    println("Harvest range is: "+range)

    average=total/d
    println("Harvest average is: "+ average)

    var sortHarvestTable= new Array[ Float](29)

    var k=1
    for(x<-1 to weekPerMonth){
      for(y<- 1 to dayPerWeek){
        sortHarvestTable(k)=harvestTable(x)(y)
        k=k+1
      }
    }

    var t : Float=0
    for(x<- 1 to d){
      for(y<- (1+x) to d){
        if(sortHarvestTable(x)>sortHarvestTable(y)){
          t=sortHarvestTable(y)
          sortHarvestTable(y)=sortHarvestTable(x)
          sortHarvestTable(x)=t
        }
      }
    }

    var m=d/2
    medium=(sortHarvestTable(m)+sortHarvestTable(m+1))/2

    println("Harvest medium is :"+medium)
    
  }
}
