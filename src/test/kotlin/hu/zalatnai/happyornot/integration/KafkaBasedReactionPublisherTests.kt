package hu.zalatnai.happyornot.integration

import hu.zalatnai.happyornot.KafkaBasedReactionPublisher
import hu.zalatnai.happyornot.Reaction
import hu.zalatnai.happyornot.ReactionPublisherStream
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.test.binder.MessageCollector
import org.springframework.messaging.Message
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.util.concurrent.TimeUnit


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("kafka")
class KafkaBasedReactionPublisherTests {

    @Autowired
    lateinit var reactionPublisherStream: ReactionPublisherStream

    @Autowired
    lateinit var kafkaBasedReactionPublisher: KafkaBasedReactionPublisher

    @Autowired
    lateinit var messageCollector: MessageCollector

    @Test
    fun `the publisher can send a serialized reaction over the channel`() {
        kafkaBasedReactionPublisher.publish(Reaction.Positive)
        val received = messageCollector.forChannel(reactionPublisherStream.reactionOutput()).poll(1, TimeUnit.SECONDS) as Message<String>

        assertThat(received.payload, equalTo("P"))
    }
}