$("div").find(".b")  //p.b
$("div").filter(".b") //div.b
$(".b").not("p") //div.b
$("div").has("p") //div containing p
$("div").has("input", type: "text") //div containing the input with a type attribute of “text”