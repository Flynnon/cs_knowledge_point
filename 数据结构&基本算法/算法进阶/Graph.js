function  Graph() {
    this.vertexs = [];//顶点集合
    this.edges = new Map(); //边的集合
}
//添加顶点
Graph.prototype.addVertex = function(v){
    this.vertexs.push(v);
    this.edges.set(v,[]);
}
//添加边
Graph.prototype.addEdge = function(v,w){
    let vEdge = this.edges.get(v);
    vEdge.push(w);
    let wEdge = this.edges.get(w);
    wEdge.push(v);
    this.edges.set(v,vEdge);
    this.edges.set(w,wEdge);
}
//重写toString方法
Graph.prototype.toString = function(){
    let s = "";
    for (let i = 0;i < this.vertexs.length;i++){
        s += this.vertexs[i] + " -> ";
        
        let neighbors = this.edges.get(this.vertexs[i])
        for(let j = 0; j < neighbors.length;j++){
            s += neighbors[j]+" ";
        }
        s+="\n";
    }
    return s;
}
var graph = new Graph()
var vertices = [1, 2, 3, 4, 5]
for (var i=0; i<vertices.length; i++) {
    graph.addVertex(vertices[i])
}
graph.addEdge(1, 4); //增加边
graph.addEdge(1, 3);
graph.addEdge(2, 3);
graph.addEdge(2, 5);
console.log(graph.toString())
Graph.prototype.dfs = function(){
    let context = this;
    var marked = new Map();
    for(let i = 0;i < this.vertexs.length;i++){
        let vertex = this.vertexs[i];
        if(!marked.get(vertex)){
            dfsVisit(vertex)
        }
    }
    function dfsVisit (v){
        let edges = context.edges;
        marked.set(v,true);
        let neighbors = edges.get(v);
        for(let i = 0;i < neighbors.length;i++){
            if(!marked.get(neighbors[i])){
                dfsVisit(neighbors[i])
            }
        }
    }
    console.log(marked);
}
// graph.dfs();
Graph.prototype.bfs = function(v){
    var queue = [],marked = new Map();
    marked.set(v,true);
    queue.push(v);
    while (queue.length>0){
        let s = queue.shift();
        let neighbors = this.edges.get(s);
        console.log(neighbors)
        if(neighbors){
            for(let i = 0;i < neighbors.length;i++){
                let vertex = neighbors[i];
                if(!marked.get(vertex)){
                    marked.set(vertex,true);
                    queue.push(vertex);
                }
                
            }
        }
    }
    return marked;
}