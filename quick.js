
//match all ‘div’ elements on the page
$("div")
//match all 'div' elements with a title attribute value of 'section‘
$("div", title: "section")
//match the first 'div' element with the class 'main‘
$("div.main", 0)
//match all 'div' element with the class 'main‘
$("div.main")
 
$("p").max { it.text() }.text() == "2"
 

$("div").filter(".b")$("div").has("p")
$("div").has("input", type: "text")
 


$("div").filter(".b")$("div").has("p")
$("div").has("input", type: "text")
 
$("div").filter(".b")
$("div").has("p")
$("div").has("input", type: "text") 
