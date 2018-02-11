package hu.zalatnai.happyornot.integration

import hu.zalatnai.happyornot.ReactionPublisherStream
import hu.zalatnai.happyornot.ReactionStore
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.messaging.support.GenericMessage
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("kafka")
class KafkaBasedReactionConsumerTests {

    @Autowired
    lateinit var reactionPublisherStream: ReactionPublisherStream

    @Autowired
    lateinit var reactionStore: ReactionStore

    @Test
    fun `in case of a positive reaction event the positive reaction counter is incremented`() {
        reactionPublisherStream.reactionInput().send(GenericMessage("P"))

        assertThat(reactionStore.positive, equalTo(1))
    }

    @Test
    fun `in case of a negative reaction event the negative reaction counter is incremented`() {
        reactionPublisherStream.reactionInput().send(GenericMessage("N"))

        assertThat(reactionStore.negative, equalTo(1))
    }
}