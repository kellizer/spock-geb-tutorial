package com.spockgeb.spock.extensions

import spock.lang.Specification

/**
 *
 */
class StacktraceDiffSpecification extends Specification {

    def "Lets compare a very very long string"() {
        expect:
        BASE == "Vel case soluta labore ne. Ei sed malorum persius alienum. Te est ridens mediocritatem, pro dolorem forensibus et, te mollis dolorem ancillae pro. His ad iisque denique, eros facer tincidunt ea mel, noster option ex nec. An vis blandit hendrerit conceptam, sea ea clita sadipscing.\n" +
                "\n" +
                "Falli invidunt vivendum vix ei. Nec omnes dolores honestatis ne, quo ea detracto apeirian assueverit, virtute accusam dolores usu an. Delectus suavitate cu est, id facer simul iudicabit mei. Eam purto petentium an, mei iudico oblique nominati no, nec discere docendi no. Odio dicat persequeris id mea. Quodsi iriure timeam sed in.\n" +
                "\n" +
                "Sit ad senserit explicari. Erant virtute patrioque sea ea, agam augue persecuti et duo. Eum simul soluta suscipiantur ei, no errem iuvaret pri. Mea omnis solet ex, te porro postea sadipscing vel, at sit melius ocurreret.\n" +
                "\n" +
                "Id nc doming quaerendum, ad facilisis vituperatoribus nam, decore aliquid eum eu. Nec ei minimum consetetur, ex dicant accumsan consequat cum. Ludus choro an eam, in aeque dignissim per. Vis ne exerci perpetua, mea elit vulputate et. Cu vix ullamcorper intellegebat, magna euripidis ei duo. Pri scripta eripuit in.\n" +
                "\n" +
                "Vel odio unum ex, ex oblique detracto per, eum et partem ignota. Pri te illum pertinax, has ut tibique intellegat. Eum saepe atomorum appellantur te, usu at ullum contentiones, impetus senserit te has. Nec et doming pertinacia, eius noster nominavi id his.\n" +
                "\n" +
                "Et sea nulla latine invenire. An cum augue recusabo indoctum, eu alii singulis cum, nusquam fastidii mea eu. Ad convenire dissentias sed, laoreet explicari cu nec. Noster definitionem mea cu, vero tation iracundia pri no. Duo iusto appareat lucilius ne. An usu novum quaerendum. Vis id adolescens appellantur.\n" +
                "\n" +
                "Choro malorum appareat cum te, vis ne salutatus assentior philosophia, aperiam luptatum disputando ne est. Vis et nusquam insolens accommodare. Congue alienum suscipit ad vel, suas recusabo deterruisset ut est, an quis tollit petentium duo. An quem sonet ullamcorper vix, id sea volutpat pericula temporibus.\n" +
                "\n" +
                "Cu detracto perfecto sit. Sea in quodsi petentium adversarium. Ex altera accusata usu, ut dolore fuisset vix. Mea ad quis animal virtute, numquam voluptatum eu mei.\n" +
                "\n" +
                "Cu pri quis omnes, ex sit fugit quaeque definitiones, pro ea tale solet accumsan. No vel idque nemore voluptaria, meliore complectitur pri id, id sint electram instructior sea. Ius eu albucius petentium torquatos. Sed equidem eleifend quaerendum ea, vivendo oporteat adipisci nec in, nec et probo meliore. Vix aperiri omittantur comprehensam te, erat illum sententiae nam ei, ei nec ullum primis omnium. Ius ea malis summo elitr, ei error dignissim duo.\n" +
                "\n" +
                "Alii diceret labores te nam. Mucius maiorum id vel. Deserunt philosophia an sed, in tempor referrentur conclusionemque sit, bonorum delicata ocurreret vel at. Eu cetero contentiones nec, maiorum philosophia quo cu, nec id eripuit intellegebat. An oratio voluptaria nam, est mundi putant assentior ne.\n" +
                "      "

    }


    static String BASE = "Vel case soluta labore ne. Ei sed malorum persius alienum. Te est ridens mediocritatem, pro dolorem forensibus et, te mollis dolorem ancillae pro. His ad iisque denique, eros facer tincidunt ea mel, noster option ex nec. An vis blandit hendrerit conceptam, sea ea clita sadipscing.\n" +
            "\n" +
            "Falli invidunt vivendum vix ei. Nec omnes dolores honestatis ne, quo ea detracto apeirian assueverit, virtute accusam dolores usu an. Delectus suavitate cu est, id facer simul iudicabit mei. Eam purto petentium an, mei iudico oblique nominati no, nec discere docendi no. Odio dicat persequeris id mea. Quodsi iriure timeam sed in.\n" +
            "\n" +
            "Sit ad senserit explicari. Erant virtute patrioque sea ea, agam augue persecuti et duo. Eum simul soluta suscipiantur ei, no errem iuvaret pri. Mea omnis solet ex, te porro postea sadipscing vel, at sit melius ocurreret.\n" +
            "\n" +
            "Id nec doming quaerendum, ad facilisis vituperatoribus nam, decore aliquid eum eu. Nec ei minimum consetetur, ex dicant accumsan consequat cum. Ludus choro an eam, in aeque dignissim per. Vis ne exerci perpetua, mea elit vulputate et. Cu vix ullamcorper intellegebat, magna euripidis ei duo. Pri scripta eripuit in.\n" +
            "\n" +
            "Vel odio unum ex, ex oblique detracto per, eum et partem ignota. Pri te illum pertinax, has ut tibique intellegat. Eum saepe atomorum appellantur te, usu at ullum contentiones, impetus senserit te has. Nec et doming pertinacia, eius noster nominavi id his.\n" +
            "\n" +
            "Et sea nulla latine invenire. An cum augue recusabo indoctum, eu alii singulis cum, nusquam fastidii mea eu. Ad convenire dissentias sed, laoreet explicari cu nec. Noster definitionem mea cu, vero tation iracundia pri no. Duo iusto appareat lucilius ne. An usu novum quaerendum. Vis id adolescens appellantur.\n" +
            "\n" +
            "Choro malorum appareat cum te, vis ne salutatus assentior philosophia, aperiam luptatum disputando ne est. Vis et nusquam insolens accommodare. Congue alienum suscipit ad vel, suas recusabo deterruisset ut est, an quis tollit petentium duo. An quem sonet ullamcorper vix, id sea volutpat pericula temporibus.\n" +
            "\n" +
            "Cu detracto perfecto sit. Sea in quodsi petentium adversarium. Ex altera accusata usu, ut dolore fuisset vix. Mea ad quis animal virtute, numquam voluptatum eu mei.\n" +
            "\n" +
            "Cu pri quis omnes, ex sit fugit quaeque definitiones, pro ea tale solet accumsan. No vel idque nemore voluptaria, meliore complectitur pri id, id sint electram instructior sea. Ius eu albucius petentium torquatos. Sed equidem eleifend quaerendum ea, vivendo oporteat adipisci nec in, nec et probo meliore. Vix aperiri omittantur comprehensam te, erat illum sententiae nam ei, ei nec ullum primis omnium. Ius ea malis summo elitr, ei error dignissim duo.\n" +
            "\n" +
            "Alii diceret labores te nam. Mucius maiorum id vel. Deserunt philosophia an sed, in tempor referrentur conclusionemque sit, bonorum delicata ocurreret vel at. Eu cetero contentiones nec, maiorum philosophia quo cu, nec id eripuit intellegebat. An oratio voluptaria nam, est mundi putant assentior ne.\n" +
            "      "

}




